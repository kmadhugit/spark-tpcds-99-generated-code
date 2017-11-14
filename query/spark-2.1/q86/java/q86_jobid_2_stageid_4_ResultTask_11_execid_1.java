/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */
/* 012 */   public SpecificUnsafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     result = new UnsafeRow(8);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 96);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 8);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_1(InternalRow i) {
/* 026 */
/* 027 */
/* 028 */     boolean isNull6 = i.isNullAt(6);
/* 029 */     double value6 = isNull6 ? -1.0 : (i.getDouble(6));
/* 030 */     if (isNull6) {
/* 031 */       rowWriter.setNullAt(6);
/* 032 */     } else {
/* 033 */       rowWriter.write(6, value6);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull7 = i.isNullAt(7);
/* 038 */     int value7 = isNull7 ? -1 : (i.getInt(7));
/* 039 */     if (isNull7) {
/* 040 */       rowWriter.setNullAt(7);
/* 041 */     } else {
/* 042 */       rowWriter.write(7, value7);
/* 043 */     }
/* 044 */
/* 045 */   }
/* 046 */
/* 047 */
/* 048 */   private void apply_0(InternalRow i) {
/* 049 */
/* 050 */
/* 051 */     boolean isNull = i.isNullAt(0);
/* 052 */     double value = isNull ? -1.0 : (i.getDouble(0));
/* 053 */     if (isNull) {
/* 054 */       rowWriter.setNullAt(0);
/* 055 */     } else {
/* 056 */       rowWriter.write(0, value);
/* 057 */     }
/* 058 */
/* 059 */
/* 060 */     boolean isNull1 = i.isNullAt(1);
/* 061 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 062 */     if (isNull1) {
/* 063 */       rowWriter.setNullAt(1);
/* 064 */     } else {
/* 065 */       rowWriter.write(1, value1);
/* 066 */     }
/* 067 */
/* 068 */
/* 069 */     boolean isNull2 = i.isNullAt(2);
/* 070 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 071 */     if (isNull2) {
/* 072 */       rowWriter.setNullAt(2);
/* 073 */     } else {
/* 074 */       rowWriter.write(2, value2);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     byte value3 = i.getByte(3);
/* 079 */     rowWriter.write(3, value3);
/* 080 */
/* 081 */
/* 082 */     byte value4 = i.getByte(4);
/* 083 */     rowWriter.write(4, value4);
/* 084 */
/* 085 */
/* 086 */     boolean isNull5 = i.isNullAt(5);
/* 087 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(5));
/* 088 */     if (isNull5) {
/* 089 */       rowWriter.setNullAt(5);
/* 090 */     } else {
/* 091 */       rowWriter.write(5, value5);
/* 092 */     }
/* 093 */
/* 094 */   }
/* 095 */
/* 096 */
/* 097 */   // Scala.Function1 need this
/* 098 */   public java.lang.Object apply(java.lang.Object row) {
/* 099 */     return apply((InternalRow) row);
/* 100 */   }
/* 101 */
/* 102 */   public UnsafeRow apply(InternalRow i) {
/* 103 */     holder.reset();
/* 104 */
/* 105 */     rowWriter.zeroOutNullBytes();
/* 106 */     apply_0(i);
/* 107 */     apply_1(i);
/* 108 */     result.setTotalSize(holder.totalSize());
/* 109 */     return result;
/* 110 */   }
/* 111 */ }
