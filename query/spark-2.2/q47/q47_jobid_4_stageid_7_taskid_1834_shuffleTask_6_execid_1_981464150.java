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
/* 030 */     int value6 = isNull6 ? -1 : (i.getInt(4));
/* 031 */     if (!isNull6) {
/* 032 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value6, value1);
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull7 = i.isNullAt(5);
/* 036 */     int value7 = isNull7 ? -1 : (i.getInt(5));
/* 037 */     if (!isNull7) {
/* 038 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value7, value1);
/* 039 */     }
/* 040 */
/* 041 */   }
/* 042 */
/* 043 */
/* 044 */   private void apply_0(InternalRow i) {
/* 045 */
/* 046 */     boolean isNull2 = i.isNullAt(0);
/* 047 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 048 */     if (!isNull2) {
/* 049 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 050 */     }
/* 051 */
/* 052 */     boolean isNull3 = i.isNullAt(1);
/* 053 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(1));
/* 054 */     if (!isNull3) {
/* 055 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value3.getBaseObject(), value3.getBaseOffset(), value3.numBytes(), value1);
/* 056 */     }
/* 057 */
/* 058 */     boolean isNull4 = i.isNullAt(2);
/* 059 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(2));
/* 060 */     if (!isNull4) {
/* 061 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value4.getBaseObject(), value4.getBaseOffset(), value4.numBytes(), value1);
/* 062 */     }
/* 063 */
/* 064 */     boolean isNull5 = i.isNullAt(3);
/* 065 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(3));
/* 066 */     if (!isNull5) {
/* 067 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value5.getBaseObject(), value5.getBaseOffset(), value5.numBytes(), value1);
/* 068 */     }
/* 069 */
/* 070 */   }
/* 071 */
/* 072 */
/* 073 */   // Scala.Function1 need this
/* 074 */   public java.lang.Object apply(java.lang.Object row) {
/* 075 */     return apply((InternalRow) row);
/* 076 */   }
/* 077 */
/* 078 */   public UnsafeRow apply(InternalRow i) {
/* 079 */     boolean isNull = false;
/* 080 */
/* 081 */     value1 = 42;
/* 082 */     apply_0(i);
/* 083 */     apply_1(i);
/* 084 */
/* 085 */     int value = -1;
/* 086 */
/* 087 */     int remainder = value1 % 64;
/* 088 */     if (remainder < 0) {
/* 089 */       value = (remainder + 64) % 64;
/* 090 */     } else {
/* 091 */       value = remainder;
/* 092 */     }
/* 093 */     rowWriter.write(0, value);
/* 094 */     return result;
/* 095 */   }
/* 096 */ }
