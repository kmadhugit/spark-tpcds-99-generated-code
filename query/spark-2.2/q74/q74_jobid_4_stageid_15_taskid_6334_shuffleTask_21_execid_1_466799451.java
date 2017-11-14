/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private UTF8String smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private UTF8String smj_value3;
/* 015 */   private UTF8String smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private double smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private UTF8String smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private UTF8String smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private UTF8String smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private double smj_value9;
/* 026 */   private boolean smj_isNull7;
/* 027 */   private double smj_value10;
/* 028 */   private boolean smj_isNull8;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 030 */   private UnsafeRow smj_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 033 */   private UnsafeRow project_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 036 */
/* 037 */   public GeneratedIterator(Object[] references) {
/* 038 */     this.references = references;
/* 039 */   }
/* 040 */
/* 041 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 042 */     partitionIndex = index;
/* 043 */     this.inputs = inputs;
/* 044 */     smj_leftInput = inputs[0];
/* 045 */     smj_rightInput = inputs[1];
/* 046 */
/* 047 */     smj_rightRow = null;
/* 048 */
/* 049 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 050 */
/* 051 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 052 */     smj_result = new UnsafeRow(9);
/* 053 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 160);
/* 054 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 9);
/* 055 */     project_result = new UnsafeRow(3);
/* 056 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 057 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private boolean findNextInnerJoinRows(
/* 062 */     scala.collection.Iterator leftIter,
/* 063 */     scala.collection.Iterator rightIter) {
/* 064 */     smj_leftRow = null;
/* 065 */     int comp = 0;
/* 066 */     while (smj_leftRow == null) {
/* 067 */       if (!leftIter.hasNext()) return false;
/* 068 */       smj_leftRow = (InternalRow) leftIter.next();
/* 069 */
/* 070 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 071 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 072 */       if (smj_isNull) {
/* 073 */         smj_leftRow = null;
/* 074 */         continue;
/* 075 */       }
/* 076 */       if (!smj_matches.isEmpty()) {
/* 077 */         comp = 0;
/* 078 */         if (comp == 0) {
/* 079 */           comp = smj_value.compare(smj_value3);
/* 080 */         }
/* 081 */
/* 082 */         if (comp == 0) {
/* 083 */           return true;
/* 084 */         }
/* 085 */         smj_matches.clear();
/* 086 */       }
/* 087 */
/* 088 */       do {
/* 089 */         if (smj_rightRow == null) {
/* 090 */           if (!rightIter.hasNext()) {
/* 091 */             smj_value3 = smj_value.clone();
/* 092 */             return !smj_matches.isEmpty();
/* 093 */           }
/* 094 */           smj_rightRow = (InternalRow) rightIter.next();
/* 095 */
/* 096 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 097 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 098 */           if (smj_isNull1) {
/* 099 */             smj_rightRow = null;
/* 100 */             continue;
/* 101 */           }
/* 102 */           smj_value2 = smj_value1.clone();
/* 103 */         }
/* 104 */
/* 105 */         comp = 0;
/* 106 */         if (comp == 0) {
/* 107 */           comp = smj_value.compare(smj_value2);
/* 108 */         }
/* 109 */
/* 110 */         if (comp > 0) {
/* 111 */           smj_rightRow = null;
/* 112 */         } else if (comp < 0) {
/* 113 */           if (!smj_matches.isEmpty()) {
/* 114 */             smj_value3 = smj_value.clone();
/* 115 */             return true;
/* 116 */           }
/* 117 */           smj_leftRow = null;
/* 118 */         } else {
/* 119 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 120 */           smj_rightRow = null;;
/* 121 */         }
/* 122 */       } while (smj_leftRow != null);
/* 123 */     }
/* 124 */     return false; // unreachable
/* 125 */   }
/* 126 */
/* 127 */   protected void processNext() throws java.io.IOException {
/* 128 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 129 */       boolean smj_loaded = false;
/* 130 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 131 */       smj_value5 = smj_isNull3 ? -1.0 : (smj_leftRow.getDouble(1));
/* 132 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 133 */       smj_value9 = smj_isNull7 ? -1.0 : (smj_leftRow.getDouble(5));
/* 134 */       smj_isNull8 = smj_leftRow.isNullAt(6);
/* 135 */       smj_value10 = smj_isNull8 ? -1.0 : (smj_leftRow.getDouble(6));
/* 136 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 137 */       while (smj_iterator.hasNext()) {
/* 138 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 139 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(1);
/* 140 */         double smj_value12 = smj_isNull10 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 141 */
/* 142 */         boolean smj_isNull11 = true;
/* 143 */         boolean smj_value13 = false;
/* 144 */
/* 145 */         boolean smj_isNull12 = true;
/* 146 */         double smj_value14 = -1.0;
/* 147 */
/* 148 */         boolean smj_isNull13 = true;
/* 149 */         boolean smj_value15 = false;
/* 150 */
/* 151 */         if (!smj_isNull8) {
/* 152 */           smj_isNull13 = false; // resultCode could change nullability.
/* 153 */           smj_value15 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value10, 0.0D) > 0;
/* 154 */
/* 155 */         }
/* 156 */         if (!smj_isNull13 && smj_value15) {
/* 157 */           boolean smj_isNull16 = false;
/* 158 */           double smj_value18 = -1.0;
/* 159 */           if (smj_isNull8 || smj_value10 == 0) {
/* 160 */             smj_isNull16 = true;
/* 161 */           } else {
/* 162 */             if (smj_isNull10) {
/* 163 */               smj_isNull16 = true;
/* 164 */             } else {
/* 165 */               smj_value18 = (double)(smj_value12 / smj_value10);
/* 166 */             }
/* 167 */           }
/* 168 */           smj_isNull12 = smj_isNull16;
/* 169 */           smj_value14 = smj_value18;
/* 170 */         }
/* 171 */
/* 172 */         else {
/* 173 */           final double smj_value21 = -1.0;
/* 174 */           smj_isNull12 = true;
/* 175 */           smj_value14 = smj_value21;
/* 176 */         }
/* 177 */         if (!smj_isNull12) {
/* 178 */           boolean smj_isNull20 = true;
/* 179 */           double smj_value22 = -1.0;
/* 180 */
/* 181 */           boolean smj_isNull21 = true;
/* 182 */           boolean smj_value23 = false;
/* 183 */
/* 184 */           if (!smj_isNull3) {
/* 185 */             smj_isNull21 = false; // resultCode could change nullability.
/* 186 */             smj_value23 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value5, 0.0D) > 0;
/* 187 */
/* 188 */           }
/* 189 */           if (!smj_isNull21 && smj_value23) {
/* 190 */             boolean smj_isNull24 = false;
/* 191 */             double smj_value26 = -1.0;
/* 192 */             if (smj_isNull3 || smj_value5 == 0) {
/* 193 */               smj_isNull24 = true;
/* 194 */             } else {
/* 195 */               if (smj_isNull7) {
/* 196 */                 smj_isNull24 = true;
/* 197 */               } else {
/* 198 */                 smj_value26 = (double)(smj_value9 / smj_value5);
/* 199 */               }
/* 200 */             }
/* 201 */             smj_isNull20 = smj_isNull24;
/* 202 */             smj_value22 = smj_value26;
/* 203 */           }
/* 204 */
/* 205 */           else {
/* 206 */             final double smj_value29 = -1.0;
/* 207 */             smj_isNull20 = true;
/* 208 */             smj_value22 = smj_value29;
/* 209 */           }
/* 210 */           if (!smj_isNull20) {
/* 211 */             smj_isNull11 = false; // resultCode could change nullability.
/* 212 */             smj_value13 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value14, smj_value22) > 0;
/* 213 */
/* 214 */           }
/* 215 */
/* 216 */         }
/* 217 */         if (smj_isNull11 || !smj_value13) continue;
/* 218 */         if (!smj_loaded) {
/* 219 */           smj_loaded = true;
/* 220 */           smj_isNull2 = smj_leftRow.isNullAt(0);
/* 221 */           smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 222 */           smj_isNull4 = smj_leftRow.isNullAt(2);
/* 223 */           smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 224 */           smj_isNull5 = smj_leftRow.isNullAt(3);
/* 225 */           smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 226 */           smj_isNull6 = smj_leftRow.isNullAt(4);
/* 227 */           smj_value8 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(4));
/* 228 */         }
/* 229 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(0);
/* 230 */         UTF8String smj_value11 = smj_isNull9 ? null : (smj_rightRow1.getUTF8String(0));
/* 231 */         smj_numOutputRows.add(1);
/* 232 */
/* 233 */         project_holder.reset();
/* 234 */
/* 235 */         project_rowWriter.zeroOutNullBytes();
/* 236 */
/* 237 */         if (smj_isNull4) {
/* 238 */           project_rowWriter.setNullAt(0);
/* 239 */         } else {
/* 240 */           project_rowWriter.write(0, smj_value6);
/* 241 */         }
/* 242 */
/* 243 */         if (smj_isNull5) {
/* 244 */           project_rowWriter.setNullAt(1);
/* 245 */         } else {
/* 246 */           project_rowWriter.write(1, smj_value7);
/* 247 */         }
/* 248 */
/* 249 */         if (smj_isNull6) {
/* 250 */           project_rowWriter.setNullAt(2);
/* 251 */         } else {
/* 252 */           project_rowWriter.write(2, smj_value8);
/* 253 */         }
/* 254 */         project_result.setTotalSize(project_holder.totalSize());
/* 255 */         append(project_result.copy());
/* 256 */
/* 257 */       }
/* 258 */       if (shouldStop()) return;
/* 259 */     }
/* 260 */   }
/* 261 */ }
