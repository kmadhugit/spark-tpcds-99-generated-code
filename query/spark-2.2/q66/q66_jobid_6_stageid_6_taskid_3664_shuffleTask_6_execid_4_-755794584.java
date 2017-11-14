/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private int value1;
/* 009 */   private UnsafeRow result;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 012 */
/* 013 */   public SpecificUnsafeProjection(Object[] references) {
/* 014 */     this.references = references;
/* 015 */
/* 016 */     result = new UnsafeRow(1);
/* 017 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 018 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 019 */
/* 020 */   }
/* 021 */
/* 022 */   public void initialize(int partitionIndex) {
/* 023 */
/* 024 */   }
/* 025 */
/* 026 */
/* 027 */   private void apply_1(InternalRow i) {
/* 028 */
/* 029 */     boolean isNull6 = i.isNullAt(4);
/* 030 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(4));
/* 031 */     if (!isNull6) {
/* 032 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value6.getBaseObject(), value6.getBaseOffset(), value6.numBytes(), value1);
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull7 = i.isNullAt(5);
/* 036 */     UTF8String value7 = isNull7 ? null : (i.getUTF8String(5));
/* 037 */     if (!isNull7) {
/* 038 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value7.getBaseObject(), value7.getBaseOffset(), value7.numBytes(), value1);
/* 039 */     }
/* 040 */
/* 041 */     boolean isNull8 = i.isNullAt(6);
/* 042 */     int value8 = isNull8 ? -1 : (i.getInt(6));
/* 043 */     if (!isNull8) {
/* 044 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value8, value1);
/* 045 */     }
/* 046 */
/* 047 */   }
/* 048 */
/* 049 */
/* 050 */   private void apply_0(InternalRow i) {
/* 051 */
/* 052 */     boolean isNull2 = i.isNullAt(0);
/* 053 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 054 */     if (!isNull2) {
/* 055 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 056 */     }
/* 057 */
/* 058 */     boolean isNull3 = i.isNullAt(1);
/* 059 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 060 */     if (!isNull3) {
/* 061 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value3, value1);
/* 062 */     }
/* 063 */
/* 064 */     boolean isNull4 = i.isNullAt(2);
/* 065 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(2));
/* 066 */     if (!isNull4) {
/* 067 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value4.getBaseObject(), value4.getBaseOffset(), value4.numBytes(), value1);
/* 068 */     }
/* 069 */
/* 070 */     boolean isNull5 = i.isNullAt(3);
/* 071 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(3));
/* 072 */     if (!isNull5) {
/* 073 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value5.getBaseObject(), value5.getBaseOffset(), value5.numBytes(), value1);
/* 074 */     }
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */
/* 079 */   // Scala.Function1 need this
/* 080 */   public java.lang.Object apply(java.lang.Object row) {
/* 081 */     return apply((InternalRow) row);
/* 082 */   }
/* 083 */
/* 084 */   public UnsafeRow apply(InternalRow i) {
/* 085 */     boolean isNull = false;
/* 086 */
/* 087 */     value1 = 42;
/* 088 */     apply_0(i);
/* 089 */     apply_1(i);
/* 090 */
/* 091 */     int value = -1;
/* 092 */
/* 093 */     int remainder = value1 % 64;
/* 094 */     if (remainder < 0) {
/* 095 */       value = (remainder + 64) % 64;
/* 096 */     } else {
/* 097 */       value = remainder;
/* 098 */     }
/* 099 */     rowWriter.write(0, value);
/* 100 */     return result;
/* 101 */   }
/* 102 */ }
