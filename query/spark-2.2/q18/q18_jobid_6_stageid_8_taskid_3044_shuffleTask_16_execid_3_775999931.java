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
/* 014 */     result = new UnsafeRow(14);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 224);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 14);
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
/* 029 */     Decimal value4 = isNull4 ? null : (i.getDecimal(4, 22, 2));
/* 030 */     if (isNull4) {
/* 031 */       rowWriter.write(4, (Decimal) null, 22, 2);
/* 032 */     } else {
/* 033 */       rowWriter.write(4, value4, 22, 2);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull5 = i.isNullAt(5);
/* 038 */     long value5 = isNull5 ? -1L : (i.getLong(5));
/* 039 */     if (isNull5) {
/* 040 */       rowWriter.setNullAt(5);
/* 041 */     } else {
/* 042 */       rowWriter.write(5, value5);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull6 = i.isNullAt(6);
/* 047 */     Decimal value6 = isNull6 ? null : (i.getDecimal(6, 22, 2));
/* 048 */     if (isNull6) {
/* 049 */       rowWriter.write(6, (Decimal) null, 22, 2);
/* 050 */     } else {
/* 051 */       rowWriter.write(6, value6, 22, 2);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull7 = i.isNullAt(7);
/* 056 */     long value7 = isNull7 ? -1L : (i.getLong(7));
/* 057 */     if (isNull7) {
/* 058 */       rowWriter.setNullAt(7);
/* 059 */     } else {
/* 060 */       rowWriter.write(7, value7);
/* 061 */     }
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */
/* 066 */   private void apply_3(InternalRow i) {
/* 067 */
/* 068 */
/* 069 */     boolean isNull12 = i.isNullAt(12);
/* 070 */     Decimal value12 = isNull12 ? null : (i.getDecimal(12, 22, 2));
/* 071 */     if (isNull12) {
/* 072 */       rowWriter.write(12, (Decimal) null, 22, 2);
/* 073 */     } else {
/* 074 */       rowWriter.write(12, value12, 22, 2);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull13 = i.isNullAt(13);
/* 079 */     long value13 = isNull13 ? -1L : (i.getLong(13));
/* 080 */     if (isNull13) {
/* 081 */       rowWriter.setNullAt(13);
/* 082 */     } else {
/* 083 */       rowWriter.write(13, value13);
/* 084 */     }
/* 085 */
/* 086 */   }
/* 087 */
/* 088 */
/* 089 */   private void apply_0(InternalRow i) {
/* 090 */
/* 091 */
/* 092 */     boolean isNull = i.isNullAt(0);
/* 093 */     Decimal value = isNull ? null : (i.getDecimal(0, 22, 2));
/* 094 */     if (isNull) {
/* 095 */       rowWriter.write(0, (Decimal) null, 22, 2);
/* 096 */     } else {
/* 097 */       rowWriter.write(0, value, 22, 2);
/* 098 */     }
/* 099 */
/* 100 */
/* 101 */     boolean isNull1 = i.isNullAt(1);
/* 102 */     long value1 = isNull1 ? -1L : (i.getLong(1));
/* 103 */     if (isNull1) {
/* 104 */       rowWriter.setNullAt(1);
/* 105 */     } else {
/* 106 */       rowWriter.write(1, value1);
/* 107 */     }
/* 108 */
/* 109 */
/* 110 */     boolean isNull2 = i.isNullAt(2);
/* 111 */     Decimal value2 = isNull2 ? null : (i.getDecimal(2, 22, 2));
/* 112 */     if (isNull2) {
/* 113 */       rowWriter.write(2, (Decimal) null, 22, 2);
/* 114 */     } else {
/* 115 */       rowWriter.write(2, value2, 22, 2);
/* 116 */     }
/* 117 */
/* 118 */
/* 119 */     boolean isNull3 = i.isNullAt(3);
/* 120 */     long value3 = isNull3 ? -1L : (i.getLong(3));
/* 121 */     if (isNull3) {
/* 122 */       rowWriter.setNullAt(3);
/* 123 */     } else {
/* 124 */       rowWriter.write(3, value3);
/* 125 */     }
/* 126 */
/* 127 */   }
/* 128 */
/* 129 */
/* 130 */   private void apply_2(InternalRow i) {
/* 131 */
/* 132 */
/* 133 */     boolean isNull8 = i.isNullAt(8);
/* 134 */     Decimal value8 = isNull8 ? null : (i.getDecimal(8, 22, 2));
/* 135 */     if (isNull8) {
/* 136 */       rowWriter.write(8, (Decimal) null, 22, 2);
/* 137 */     } else {
/* 138 */       rowWriter.write(8, value8, 22, 2);
/* 139 */     }
/* 140 */
/* 141 */
/* 142 */     boolean isNull9 = i.isNullAt(9);
/* 143 */     long value9 = isNull9 ? -1L : (i.getLong(9));
/* 144 */     if (isNull9) {
/* 145 */       rowWriter.setNullAt(9);
/* 146 */     } else {
/* 147 */       rowWriter.write(9, value9);
/* 148 */     }
/* 149 */
/* 150 */
/* 151 */     boolean isNull10 = i.isNullAt(10);
/* 152 */     Decimal value10 = isNull10 ? null : (i.getDecimal(10, 22, 2));
/* 153 */     if (isNull10) {
/* 154 */       rowWriter.write(10, (Decimal) null, 22, 2);
/* 155 */     } else {
/* 156 */       rowWriter.write(10, value10, 22, 2);
/* 157 */     }
/* 158 */
/* 159 */
/* 160 */     boolean isNull11 = i.isNullAt(11);
/* 161 */     long value11 = isNull11 ? -1L : (i.getLong(11));
/* 162 */     if (isNull11) {
/* 163 */       rowWriter.setNullAt(11);
/* 164 */     } else {
/* 165 */       rowWriter.write(11, value11);
/* 166 */     }
/* 167 */
/* 168 */   }
/* 169 */
/* 170 */
/* 171 */   // Scala.Function1 need this
/* 172 */   public java.lang.Object apply(java.lang.Object row) {
/* 173 */     return apply((InternalRow) row);
/* 174 */   }
/* 175 */
/* 176 */   public UnsafeRow apply(InternalRow i) {
/* 177 */     holder.reset();
/* 178 */
/* 179 */     rowWriter.zeroOutNullBytes();
/* 180 */     apply_0(i);
/* 181 */     apply_1(i);
/* 182 */     apply_2(i);
/* 183 */     apply_3(i);
/* 184 */     result.setTotalSize(holder.totalSize());
/* 185 */     return result;
/* 186 */   }
/* 187 */ }
