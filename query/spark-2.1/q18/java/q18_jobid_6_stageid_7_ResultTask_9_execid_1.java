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
/* 028 */     rowWriter.write(3, 0L);
/* 029 */
/* 030 */
/* 031 */     boolean isNull6 = false;
/* 032 */     Decimal value6 = null;
/* 033 */     if (!false) {
/* 034 */
/* 035 */       Decimal tmpDecimal2 = Decimal.apply((long) 0);
/* 036 */
/* 037 */       if (tmpDecimal2.changePrecision(22, 2)) {
/* 038 */         value6 = tmpDecimal2;
/* 039 */       } else {
/* 040 */         isNull6 = true;
/* 041 */       }
/* 042 */
/* 043 */
/* 044 */     }
/* 045 */     if (isNull6) {
/* 046 */       rowWriter.write(4, (Decimal) null, 22, 2);
/* 047 */     } else {
/* 048 */       rowWriter.write(4, value6, 22, 2);
/* 049 */     }
/* 050 */
/* 051 */
/* 052 */     rowWriter.write(5, 0L);
/* 053 */
/* 054 */
/* 055 */     boolean isNull9 = false;
/* 056 */     Decimal value9 = null;
/* 057 */     if (!false) {
/* 058 */
/* 059 */       Decimal tmpDecimal3 = Decimal.apply((long) 0);
/* 060 */
/* 061 */       if (tmpDecimal3.changePrecision(22, 2)) {
/* 062 */         value9 = tmpDecimal3;
/* 063 */       } else {
/* 064 */         isNull9 = true;
/* 065 */       }
/* 066 */
/* 067 */
/* 068 */     }
/* 069 */     if (isNull9) {
/* 070 */       rowWriter.write(6, (Decimal) null, 22, 2);
/* 071 */     } else {
/* 072 */       rowWriter.write(6, value9, 22, 2);
/* 073 */     }
/* 074 */
/* 075 */   }
/* 076 */
/* 077 */
/* 078 */   private void apply_3(InternalRow i) {
/* 079 */
/* 080 */
/* 081 */     rowWriter.write(11, 0L);
/* 082 */
/* 083 */
/* 084 */     boolean isNull18 = false;
/* 085 */     Decimal value18 = null;
/* 086 */     if (!false) {
/* 087 */
/* 088 */       Decimal tmpDecimal6 = Decimal.apply((long) 0);
/* 089 */
/* 090 */       if (tmpDecimal6.changePrecision(22, 2)) {
/* 091 */         value18 = tmpDecimal6;
/* 092 */       } else {
/* 093 */         isNull18 = true;
/* 094 */       }
/* 095 */
/* 096 */
/* 097 */     }
/* 098 */     if (isNull18) {
/* 099 */       rowWriter.write(12, (Decimal) null, 22, 2);
/* 100 */     } else {
/* 101 */       rowWriter.write(12, value18, 22, 2);
/* 102 */     }
/* 103 */
/* 104 */
/* 105 */     rowWriter.write(13, 0L);
/* 106 */
/* 107 */   }
/* 108 */
/* 109 */
/* 110 */   private void apply_0(InternalRow i) {
/* 111 */
/* 112 */
/* 113 */     boolean isNull = false;
/* 114 */     Decimal value = null;
/* 115 */     if (!false) {
/* 116 */
/* 117 */       Decimal tmpDecimal = Decimal.apply((long) 0);
/* 118 */
/* 119 */       if (tmpDecimal.changePrecision(22, 2)) {
/* 120 */         value = tmpDecimal;
/* 121 */       } else {
/* 122 */         isNull = true;
/* 123 */       }
/* 124 */
/* 125 */
/* 126 */     }
/* 127 */     if (isNull) {
/* 128 */       rowWriter.write(0, (Decimal) null, 22, 2);
/* 129 */     } else {
/* 130 */       rowWriter.write(0, value, 22, 2);
/* 131 */     }
/* 132 */
/* 133 */
/* 134 */     rowWriter.write(1, 0L);
/* 135 */
/* 136 */
/* 137 */     boolean isNull3 = false;
/* 138 */     Decimal value3 = null;
/* 139 */     if (!false) {
/* 140 */
/* 141 */       Decimal tmpDecimal1 = Decimal.apply((long) 0);
/* 142 */
/* 143 */       if (tmpDecimal1.changePrecision(22, 2)) {
/* 144 */         value3 = tmpDecimal1;
/* 145 */       } else {
/* 146 */         isNull3 = true;
/* 147 */       }
/* 148 */
/* 149 */
/* 150 */     }
/* 151 */     if (isNull3) {
/* 152 */       rowWriter.write(2, (Decimal) null, 22, 2);
/* 153 */     } else {
/* 154 */       rowWriter.write(2, value3, 22, 2);
/* 155 */     }
/* 156 */
/* 157 */   }
/* 158 */
/* 159 */
/* 160 */   private void apply_2(InternalRow i) {
/* 161 */
/* 162 */
/* 163 */     rowWriter.write(7, 0L);
/* 164 */
/* 165 */
/* 166 */     boolean isNull12 = false;
/* 167 */     Decimal value12 = null;
/* 168 */     if (!false) {
/* 169 */
/* 170 */       Decimal tmpDecimal4 = Decimal.apply((long) 0);
/* 171 */
/* 172 */       if (tmpDecimal4.changePrecision(22, 2)) {
/* 173 */         value12 = tmpDecimal4;
/* 174 */       } else {
/* 175 */         isNull12 = true;
/* 176 */       }
/* 177 */
/* 178 */
/* 179 */     }
/* 180 */     if (isNull12) {
/* 181 */       rowWriter.write(8, (Decimal) null, 22, 2);
/* 182 */     } else {
/* 183 */       rowWriter.write(8, value12, 22, 2);
/* 184 */     }
/* 185 */
/* 186 */
/* 187 */     rowWriter.write(9, 0L);
/* 188 */
/* 189 */
/* 190 */     boolean isNull15 = false;
/* 191 */     Decimal value15 = null;
/* 192 */     if (!false) {
/* 193 */
/* 194 */       Decimal tmpDecimal5 = Decimal.apply((long) 0);
/* 195 */
/* 196 */       if (tmpDecimal5.changePrecision(22, 2)) {
/* 197 */         value15 = tmpDecimal5;
/* 198 */       } else {
/* 199 */         isNull15 = true;
/* 200 */       }
/* 201 */
/* 202 */
/* 203 */     }
/* 204 */     if (isNull15) {
/* 205 */       rowWriter.write(10, (Decimal) null, 22, 2);
/* 206 */     } else {
/* 207 */       rowWriter.write(10, value15, 22, 2);
/* 208 */     }
/* 209 */
/* 210 */   }
/* 211 */
/* 212 */
/* 213 */   // Scala.Function1 need this
/* 214 */   public java.lang.Object apply(java.lang.Object row) {
/* 215 */     return apply((InternalRow) row);
/* 216 */   }
/* 217 */
/* 218 */   public UnsafeRow apply(InternalRow i) {
/* 219 */     holder.reset();
/* 220 */
/* 221 */     rowWriter.zeroOutNullBytes();
/* 222 */     apply_0(i);
/* 223 */     apply_1(i);
/* 224 */     apply_2(i);
/* 225 */     apply_3(i);
/* 226 */     result.setTotalSize(holder.totalSize());
/* 227 */     return result;
/* 228 */   }
/* 229 */ }
