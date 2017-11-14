/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeRowJoiner();
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeRowJoiner extends org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner {
/* 006 */   private byte[] buf = new byte[64];
/* 007 */   private UnsafeRow out = new UnsafeRow(19);
/* 008 */
/* 009 */   public UnsafeRow join(UnsafeRow row1, UnsafeRow row2) {
/* 010 */     // row1: 5 fields, 1 words in bitset
/* 011 */     // row2: 14, 1 words in bitset
/* 012 */     // output: 19 fields, 1 words in bitset
/* 013 */     final int sizeInBytes = row1.getSizeInBytes() + row2.getSizeInBytes() - 8;
/* 014 */     if (sizeInBytes > buf.length) {
/* 015 */       buf = new byte[sizeInBytes];
/* 016 */     }
/* 017 */
/* 018 */     final java.lang.Object obj1 = row1.getBaseObject();
/* 019 */     final long offset1 = row1.getBaseOffset();
/* 020 */     final java.lang.Object obj2 = row2.getBaseObject();
/* 021 */     final long offset2 = row2.getBaseOffset();
/* 022 */
/* 023 */     Platform.putLong(buf, 16, Platform.getLong(obj1, offset1 + 0) | (Platform.getLong(obj2, offset2) << 5));
/* 024 */
/* 025 */     // Copy fixed length data for row1
/* 026 */     Platform.copyMemory(
/* 027 */       obj1, offset1 + 8,
/* 028 */       buf, 24,
/* 029 */       40);
/* 030 */
/* 031 */
/* 032 */     // Copy fixed length data for row2
/* 033 */     Platform.copyMemory(
/* 034 */       obj2, offset2 + 8,
/* 035 */       buf, 64,
/* 036 */       112);
/* 037 */
/* 038 */
/* 039 */     // Copy variable length data for row1
/* 040 */     long numBytesVariableRow1 = row1.getSizeInBytes() - 48;
/* 041 */     Platform.copyMemory(
/* 042 */       obj1, offset1 + 48,
/* 043 */       buf, 176,
/* 044 */       numBytesVariableRow1);
/* 045 */
/* 046 */
/* 047 */     // Copy variable length data for row2
/* 048 */     long numBytesVariableRow2 = row2.getSizeInBytes() - 120;
/* 049 */     Platform.copyMemory(
/* 050 */       obj2, offset2 + 120,
/* 051 */       buf, 176 + numBytesVariableRow1,
/* 052 */       numBytesVariableRow2);
/* 053 */
/* 054 */
/* 055 */     Platform.putLong(buf, 24, Platform.getLong(buf, 24) + (112L << 32));
/* 056 */
/* 057 */
/* 058 */     Platform.putLong(buf, 32, Platform.getLong(buf, 32) + (112L << 32));
/* 059 */
/* 060 */
/* 061 */     Platform.putLong(buf, 40, Platform.getLong(buf, 40) + (112L << 32));
/* 062 */
/* 063 */
/* 064 */     Platform.putLong(buf, 48, Platform.getLong(buf, 48) + (112L << 32));
/* 065 */
/* 066 */
/* 067 */
/* 068 */     Platform.putLong(buf, 64, Platform.getLong(buf, 64) + ((40L + numBytesVariableRow1) << 32));
/* 069 */
/* 070 */
/* 071 */
/* 072 */     Platform.putLong(buf, 80, Platform.getLong(buf, 80) + ((40L + numBytesVariableRow1) << 32));
/* 073 */
/* 074 */
/* 075 */
/* 076 */     Platform.putLong(buf, 96, Platform.getLong(buf, 96) + ((40L + numBytesVariableRow1) << 32));
/* 077 */
/* 078 */
/* 079 */
/* 080 */     Platform.putLong(buf, 112, Platform.getLong(buf, 112) + ((40L + numBytesVariableRow1) << 32));
/* 081 */
/* 082 */
/* 083 */
/* 084 */     Platform.putLong(buf, 128, Platform.getLong(buf, 128) + ((40L + numBytesVariableRow1) << 32));
/* 085 */
/* 086 */
/* 087 */
/* 088 */     Platform.putLong(buf, 144, Platform.getLong(buf, 144) + ((40L + numBytesVariableRow1) << 32));
/* 089 */
/* 090 */
/* 091 */
/* 092 */     Platform.putLong(buf, 160, Platform.getLong(buf, 160) + ((40L + numBytesVariableRow1) << 32));
/* 093 */
/* 094 */
/* 095 */
/* 096 */     out.pointTo(buf, sizeInBytes);
/* 097 */
/* 098 */     return out;
/* 099 */   }
/* 100 */ }
