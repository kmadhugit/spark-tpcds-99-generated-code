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
/* 012 */   private UTF8String smj_value12;
/* 013 */   private UTF8String smj_value13;
/* 014 */   private UTF8String smj_value14;
/* 015 */   private UTF8String smj_value15;
/* 016 */   private int smj_value16;
/* 017 */   private java.util.ArrayList smj_matches;
/* 018 */   private UTF8String smj_value17;
/* 019 */   private UTF8String smj_value18;
/* 020 */   private UTF8String smj_value19;
/* 021 */   private UTF8String smj_value20;
/* 022 */   private int smj_value21;
/* 023 */   private UTF8String smj_value22;
/* 024 */   private boolean smj_isNull12;
/* 025 */   private UTF8String smj_value23;
/* 026 */   private boolean smj_isNull13;
/* 027 */   private UTF8String smj_value24;
/* 028 */   private boolean smj_isNull14;
/* 029 */   private UTF8String smj_value25;
/* 030 */   private boolean smj_isNull15;
/* 031 */   private int smj_value26;
/* 032 */   private boolean smj_isNull16;
/* 033 */   private int smj_value27;
/* 034 */   private boolean smj_isNull17;
/* 035 */   private double smj_value28;
/* 036 */   private boolean smj_isNull18;
/* 037 */   private double smj_value29;
/* 038 */   private boolean smj_isNull19;
/* 039 */   private int smj_value30;
/* 040 */   private boolean smj_isNull20;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 042 */   private UnsafeRow smj_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 045 */   private UnsafeRow project_result;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 048 */
/* 049 */   public GeneratedIterator(Object[] references) {
/* 050 */     this.references = references;
/* 051 */   }
/* 052 */
/* 053 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 054 */     partitionIndex = index;
/* 055 */     this.inputs = inputs;
/* 056 */     smj_leftInput = inputs[0];
/* 057 */     smj_rightInput = inputs[1];
/* 058 */
/* 059 */     smj_rightRow = null;
/* 060 */
/* 061 */     smj_matches = new java.util.ArrayList();
/* 062 */
/* 063 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 064 */     smj_result = new UnsafeRow(15);
/* 065 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 256);
/* 066 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 15);
/* 067 */     project_result = new UnsafeRow(10);
/* 068 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 069 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 10);
/* 070 */
/* 071 */   }
/* 072 */
/* 073 */   private boolean findNextInnerJoinRows(
/* 074 */     scala.collection.Iterator leftIter,
/* 075 */     scala.collection.Iterator rightIter) {
/* 076 */     smj_leftRow = null;
/* 077 */     int comp = 0;
/* 078 */     while (smj_leftRow == null) {
/* 079 */       if (!leftIter.hasNext()) return false;
/* 080 */       smj_leftRow = (InternalRow) leftIter.next();
/* 081 */
/* 082 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 083 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 084 */
/* 085 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 086 */       UTF8String smj_value1 = smj_isNull1 ? null : (smj_leftRow.getUTF8String(1));
/* 087 */
/* 088 */       boolean smj_isNull2 = smj_leftRow.isNullAt(2);
/* 089 */       UTF8String smj_value2 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(2));
/* 090 */
/* 091 */       boolean smj_isNull3 = smj_leftRow.isNullAt(3);
/* 092 */       UTF8String smj_value3 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(3));
/* 093 */
/* 094 */       boolean smj_isNull4 = smj_leftRow.isNullAt(8);
/* 095 */       int smj_value4 = smj_isNull4 ? -1 : (smj_leftRow.getInt(8));
/* 096 */       if (smj_isNull || smj_isNull1 || smj_isNull2 || smj_isNull3 || smj_isNull4) {
/* 097 */         smj_leftRow = null;
/* 098 */         continue;
/* 099 */       }
/* 100 */       if (!smj_matches.isEmpty()) {
/* 101 */         comp = 0;
/* 102 */         if (comp == 0) {
/* 103 */           comp = smj_value.compare(smj_value17);
/* 104 */         }
/* 105 */         if (comp == 0) {
/* 106 */           comp = smj_value1.compare(smj_value18);
/* 107 */         }
/* 108 */         if (comp == 0) {
/* 109 */           comp = smj_value2.compare(smj_value19);
/* 110 */         }
/* 111 */         if (comp == 0) {
/* 112 */           comp = smj_value3.compare(smj_value20);
/* 113 */         }
/* 114 */         if (comp == 0) {
/* 115 */           comp = (smj_value4 > smj_value21 ? 1 : smj_value4 < smj_value21 ? -1 : 0);
/* 116 */         }
/* 117 */
/* 118 */         if (comp == 0) {
/* 119 */           return true;
/* 120 */         }
/* 121 */         smj_matches.clear();
/* 122 */       }
/* 123 */
/* 124 */       do {
/* 125 */         if (smj_rightRow == null) {
/* 126 */           if (!rightIter.hasNext()) {
/* 127 */             smj_value17 = smj_value.clone();
/* 128 */             smj_value18 = smj_value1.clone();
/* 129 */             smj_value19 = smj_value2.clone();
/* 130 */             smj_value20 = smj_value3.clone();
/* 131 */             smj_value21 = smj_value4;
/* 132 */             return !smj_matches.isEmpty();
/* 133 */           }
/* 134 */           smj_rightRow = (InternalRow) rightIter.next();
/* 135 */
/* 136 */           boolean smj_isNull5 = smj_rightRow.isNullAt(0);
/* 137 */           UTF8String smj_value5 = smj_isNull5 ? null : (smj_rightRow.getUTF8String(0));
/* 138 */
/* 139 */           boolean smj_isNull6 = smj_rightRow.isNullAt(1);
/* 140 */           UTF8String smj_value6 = smj_isNull6 ? null : (smj_rightRow.getUTF8String(1));
/* 141 */
/* 142 */           boolean smj_isNull7 = smj_rightRow.isNullAt(2);
/* 143 */           UTF8String smj_value7 = smj_isNull7 ? null : (smj_rightRow.getUTF8String(2));
/* 144 */
/* 145 */           boolean smj_isNull8 = smj_rightRow.isNullAt(3);
/* 146 */           UTF8String smj_value8 = smj_isNull8 ? null : (smj_rightRow.getUTF8String(3));
/* 147 */
/* 148 */           boolean smj_isNull9 = true;
/* 149 */           int smj_value9 = -1;
/* 150 */
/* 151 */           boolean smj_isNull10 = smj_rightRow.isNullAt(5);
/* 152 */           int smj_value10 = smj_isNull10 ? -1 : (smj_rightRow.getInt(5));
/* 153 */           if (!smj_isNull10) {
/* 154 */             smj_isNull9 = false; // resultCode could change nullability.
/* 155 */             smj_value9 = smj_value10 + 1;
/* 156 */
/* 157 */           }
/* 158 */           if (smj_isNull5 || smj_isNull6 || smj_isNull7 || smj_isNull8 || smj_isNull9) {
/* 159 */             smj_rightRow = null;
/* 160 */             continue;
/* 161 */           }
/* 162 */           smj_value12 = smj_value5.clone();
/* 163 */           smj_value13 = smj_value6.clone();
/* 164 */           smj_value14 = smj_value7.clone();
/* 165 */           smj_value15 = smj_value8.clone();
/* 166 */           smj_value16 = smj_value9;
/* 167 */         }
/* 168 */
/* 169 */         comp = 0;
/* 170 */         if (comp == 0) {
/* 171 */           comp = smj_value.compare(smj_value12);
/* 172 */         }
/* 173 */         if (comp == 0) {
/* 174 */           comp = smj_value1.compare(smj_value13);
/* 175 */         }
/* 176 */         if (comp == 0) {
/* 177 */           comp = smj_value2.compare(smj_value14);
/* 178 */         }
/* 179 */         if (comp == 0) {
/* 180 */           comp = smj_value3.compare(smj_value15);
/* 181 */         }
/* 182 */         if (comp == 0) {
/* 183 */           comp = (smj_value4 > smj_value16 ? 1 : smj_value4 < smj_value16 ? -1 : 0);
/* 184 */         }
/* 185 */
/* 186 */         if (comp > 0) {
/* 187 */           smj_rightRow = null;
/* 188 */         } else if (comp < 0) {
/* 189 */           if (!smj_matches.isEmpty()) {
/* 190 */             smj_value17 = smj_value.clone();
/* 191 */             smj_value18 = smj_value1.clone();
/* 192 */             smj_value19 = smj_value2.clone();
/* 193 */             smj_value20 = smj_value3.clone();
/* 194 */             smj_value21 = smj_value4;
/* 195 */             return true;
/* 196 */           }
/* 197 */           smj_leftRow = null;
/* 198 */         } else {
/* 199 */           smj_matches.add(smj_rightRow.copy());
/* 200 */           smj_rightRow = null;;
/* 201 */         }
/* 202 */       } while (smj_leftRow != null);
/* 203 */     }
/* 204 */     return false; // unreachable
/* 205 */   }
/* 206 */
/* 207 */   protected void processNext() throws java.io.IOException {
/* 208 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 209 */       int smj_size = smj_matches.size();
/* 210 */       smj_isNull12 = smj_leftRow.isNullAt(0);
/* 211 */       smj_value22 = smj_isNull12 ? null : (smj_leftRow.getUTF8String(0));
/* 212 */       smj_isNull13 = smj_leftRow.isNullAt(1);
/* 213 */       smj_value23 = smj_isNull13 ? null : (smj_leftRow.getUTF8String(1));
/* 214 */       smj_isNull14 = smj_leftRow.isNullAt(2);
/* 215 */       smj_value24 = smj_isNull14 ? null : (smj_leftRow.getUTF8String(2));
/* 216 */       smj_isNull15 = smj_leftRow.isNullAt(3);
/* 217 */       smj_value25 = smj_isNull15 ? null : (smj_leftRow.getUTF8String(3));
/* 218 */       smj_isNull16 = smj_leftRow.isNullAt(4);
/* 219 */       smj_value26 = smj_isNull16 ? -1 : (smj_leftRow.getInt(4));
/* 220 */       smj_isNull17 = smj_leftRow.isNullAt(5);
/* 221 */       smj_value27 = smj_isNull17 ? -1 : (smj_leftRow.getInt(5));
/* 222 */       smj_isNull18 = smj_leftRow.isNullAt(6);
/* 223 */       smj_value28 = smj_isNull18 ? -1.0 : (smj_leftRow.getDouble(6));
/* 224 */       smj_isNull19 = smj_leftRow.isNullAt(7);
/* 225 */       smj_value29 = smj_isNull19 ? -1.0 : (smj_leftRow.getDouble(7));
/* 226 */       smj_isNull20 = smj_leftRow.isNullAt(8);
/* 227 */       smj_value30 = smj_isNull20 ? -1 : (smj_leftRow.getInt(8));
/* 228 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 229 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 230 */
/* 231 */         smj_numOutputRows.add(1);
/* 232 */
/* 233 */         boolean smj_isNull25 = smj_rightRow1.isNullAt(4);
/* 234 */         double smj_value35 = smj_isNull25 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 235 */         project_holder.reset();
/* 236 */
/* 237 */         project_rowWriter.zeroOutNullBytes();
/* 238 */
/* 239 */         if (smj_isNull12) {
/* 240 */           project_rowWriter.setNullAt(0);
/* 241 */         } else {
/* 242 */           project_rowWriter.write(0, smj_value22);
/* 243 */         }
/* 244 */
/* 245 */         if (smj_isNull13) {
/* 246 */           project_rowWriter.setNullAt(1);
/* 247 */         } else {
/* 248 */           project_rowWriter.write(1, smj_value23);
/* 249 */         }
/* 250 */
/* 251 */         if (smj_isNull14) {
/* 252 */           project_rowWriter.setNullAt(2);
/* 253 */         } else {
/* 254 */           project_rowWriter.write(2, smj_value24);
/* 255 */         }
/* 256 */
/* 257 */         if (smj_isNull15) {
/* 258 */           project_rowWriter.setNullAt(3);
/* 259 */         } else {
/* 260 */           project_rowWriter.write(3, smj_value25);
/* 261 */         }
/* 262 */
/* 263 */         if (smj_isNull16) {
/* 264 */           project_rowWriter.setNullAt(4);
/* 265 */         } else {
/* 266 */           project_rowWriter.write(4, smj_value26);
/* 267 */         }
/* 268 */
/* 269 */         if (smj_isNull17) {
/* 270 */           project_rowWriter.setNullAt(5);
/* 271 */         } else {
/* 272 */           project_rowWriter.write(5, smj_value27);
/* 273 */         }
/* 274 */
/* 275 */         if (smj_isNull18) {
/* 276 */           project_rowWriter.setNullAt(6);
/* 277 */         } else {
/* 278 */           project_rowWriter.write(6, smj_value28);
/* 279 */         }
/* 280 */
/* 281 */         if (smj_isNull19) {
/* 282 */           project_rowWriter.setNullAt(7);
/* 283 */         } else {
/* 284 */           project_rowWriter.write(7, smj_value29);
/* 285 */         }
/* 286 */
/* 287 */         if (smj_isNull20) {
/* 288 */           project_rowWriter.setNullAt(8);
/* 289 */         } else {
/* 290 */           project_rowWriter.write(8, smj_value30);
/* 291 */         }
/* 292 */
/* 293 */         if (smj_isNull25) {
/* 294 */           project_rowWriter.setNullAt(9);
/* 295 */         } else {
/* 296 */           project_rowWriter.write(9, smj_value35);
/* 297 */         }
/* 298 */         project_result.setTotalSize(project_holder.totalSize());
/* 299 */         append(project_result.copy());
/* 300 */
/* 301 */       }
/* 302 */       if (shouldStop()) return;
/* 303 */     }
/* 304 */   }
/* 305 */ }
