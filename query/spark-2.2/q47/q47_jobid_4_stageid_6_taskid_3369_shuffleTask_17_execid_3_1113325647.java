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
/* 014 */     result = new UnsafeRow(9);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 128);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 9);
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
/* 028 */     boolean isNull4 = i.isNullAt(4);
/* 029 */     int value4 = isNull4 ? -1 : (i.getInt(4));
/* 030 */     if (isNull4) {
/* 031 */       rowWriter.setNullAt(4);
/* 032 */     } else {
/* 033 */       rowWriter.write(4, value4);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull5 = i.isNullAt(5);
/* 038 */     int value5 = isNull5 ? -1 : (i.getInt(5));
/* 039 */     if (isNull5) {
/* 040 */       rowWriter.setNullAt(5);
/* 041 */     } else {
/* 042 */       rowWriter.write(5, value5);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull6 = i.isNullAt(6);
/* 047 */     double value6 = isNull6 ? -1.0 : (i.getDouble(6));
/* 048 */     if (isNull6) {
/* 049 */       rowWriter.setNullAt(6);
/* 050 */     } else {
/* 051 */       rowWriter.write(6, value6);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull7 = i.isNullAt(7);
/* 056 */     double value7 = isNull7 ? -1.0 : (i.getDouble(7));
/* 057 */     if (isNull7) {
/* 058 */       rowWriter.setNullAt(7);
/* 059 */     } else {
/* 060 */       rowWriter.write(7, value7);
/* 061 */     }
/* 062 */
/* 063 */
/* 064 */     boolean isNull8 = i.isNullAt(8);
/* 065 */     double value8 = isNull8 ? -1.0 : (i.getDouble(8));
/* 066 */     if (isNull8) {
/* 067 */       rowWriter.setNullAt(8);
/* 068 */     } else {
/* 069 */       rowWriter.write(8, value8);
/* 070 */     }
/* 071 */
/* 072 */   }
/* 073 */
/* 074 */
/* 075 */   private void apply_0(InternalRow i) {
/* 076 */
/* 077 */
/* 078 */     boolean isNull = i.isNullAt(0);
/* 079 */     UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 080 */     if (isNull) {
/* 081 */       rowWriter.setNullAt(0);
/* 082 */     } else {
/* 083 */       rowWriter.write(0, value);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull1 = i.isNullAt(1);
/* 088 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 089 */     if (isNull1) {
/* 090 */       rowWriter.setNullAt(1);
/* 091 */     } else {
/* 092 */       rowWriter.write(1, value1);
/* 093 */     }
/* 094 */
/* 095 */
/* 096 */     boolean isNull2 = i.isNullAt(2);
/* 097 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 098 */     if (isNull2) {
/* 099 */       rowWriter.setNullAt(2);
/* 100 */     } else {
/* 101 */       rowWriter.write(2, value2);
/* 102 */     }
/* 103 */
/* 104 */
/* 105 */     boolean isNull3 = i.isNullAt(3);
/* 106 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 107 */     if (isNull3) {
/* 108 */       rowWriter.setNullAt(3);
/* 109 */     } else {
/* 110 */       rowWriter.write(3, value3);
/* 111 */     }
/* 112 */
/* 113 */   }
/* 114 */
/* 115 */
/* 116 */   // Scala.Function1 need this
/* 117 */   public java.lang.Object apply(java.lang.Object row) {
/* 118 */     return apply((InternalRow) row);
/* 119 */   }
/* 120 */
/* 121 */   public UnsafeRow apply(InternalRow i) {
/* 122 */     holder.reset();
/* 123 */
/* 124 */     rowWriter.zeroOutNullBytes();
/* 125 */     apply_0(i);
/* 126 */     apply_1(i);
/* 127 */     result.setTotalSize(holder.totalSize());
/* 128 */     return result;
/* 129 */   }
/* 130 */ }
