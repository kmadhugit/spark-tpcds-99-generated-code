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
/* 021 */   private double smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private double smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 026 */   private UnsafeRow smj_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 029 */   private UnsafeRow project_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 032 */
/* 033 */   public GeneratedIterator(Object[] references) {
/* 034 */     this.references = references;
/* 035 */   }
/* 036 */
/* 037 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 038 */     partitionIndex = index;
/* 039 */     this.inputs = inputs;
/* 040 */     smj_leftInput = inputs[0];
/* 041 */     smj_rightInput = inputs[1];
/* 042 */
/* 043 */     smj_rightRow = null;
/* 044 */
/* 045 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 046 */
/* 047 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 048 */     smj_result = new UnsafeRow(7);
/* 049 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 050 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 7);
/* 051 */     project_result = new UnsafeRow(1);
/* 052 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 053 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 054 */
/* 055 */   }
/* 056 */
/* 057 */   private boolean findNextInnerJoinRows(
/* 058 */     scala.collection.Iterator leftIter,
/* 059 */     scala.collection.Iterator rightIter) {
/* 060 */     smj_leftRow = null;
/* 061 */     int comp = 0;
/* 062 */     while (smj_leftRow == null) {
/* 063 */       if (!leftIter.hasNext()) return false;
/* 064 */       smj_leftRow = (InternalRow) leftIter.next();
/* 065 */
/* 066 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 067 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 068 */       if (smj_isNull) {
/* 069 */         smj_leftRow = null;
/* 070 */         continue;
/* 071 */       }
/* 072 */       if (!smj_matches.isEmpty()) {
/* 073 */         comp = 0;
/* 074 */         if (comp == 0) {
/* 075 */           comp = smj_value.compare(smj_value3);
/* 076 */         }
/* 077 */
/* 078 */         if (comp == 0) {
/* 079 */           return true;
/* 080 */         }
/* 081 */         smj_matches.clear();
/* 082 */       }
/* 083 */
/* 084 */       do {
/* 085 */         if (smj_rightRow == null) {
/* 086 */           if (!rightIter.hasNext()) {
/* 087 */             smj_value3 = smj_value.clone();
/* 088 */             return !smj_matches.isEmpty();
/* 089 */           }
/* 090 */           smj_rightRow = (InternalRow) rightIter.next();
/* 091 */
/* 092 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 093 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 094 */           if (smj_isNull1) {
/* 095 */             smj_rightRow = null;
/* 096 */             continue;
/* 097 */           }
/* 098 */           smj_value2 = smj_value1.clone();
/* 099 */         }
/* 100 */
/* 101 */         comp = 0;
/* 102 */         if (comp == 0) {
/* 103 */           comp = smj_value.compare(smj_value2);
/* 104 */         }
/* 105 */
/* 106 */         if (comp > 0) {
/* 107 */           smj_rightRow = null;
/* 108 */         } else if (comp < 0) {
/* 109 */           if (!smj_matches.isEmpty()) {
/* 110 */             smj_value3 = smj_value.clone();
/* 111 */             return true;
/* 112 */           }
/* 113 */           smj_leftRow = null;
/* 114 */         } else {
/* 115 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 116 */           smj_rightRow = null;;
/* 117 */         }
/* 118 */       } while (smj_leftRow != null);
/* 119 */     }
/* 120 */     return false; // unreachable
/* 121 */   }
/* 122 */
/* 123 */   protected void processNext() throws java.io.IOException {
/* 124 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 125 */       boolean smj_loaded = false;
/* 126 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 127 */       smj_value5 = smj_isNull3 ? -1.0 : (smj_leftRow.getDouble(1));
/* 128 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 129 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(3));
/* 130 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 131 */       smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(4));
/* 132 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 133 */       while (smj_iterator.hasNext()) {
/* 134 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 135 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(1);
/* 136 */         double smj_value10 = smj_isNull8 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 137 */
/* 138 */         boolean smj_isNull9 = true;
/* 139 */         boolean smj_value11 = false;
/* 140 */
/* 141 */         boolean smj_isNull10 = true;
/* 142 */         double smj_value12 = -1.0;
/* 143 */
/* 144 */         boolean smj_isNull11 = true;
/* 145 */         boolean smj_value13 = false;
/* 146 */
/* 147 */         if (!smj_isNull6) {
/* 148 */           smj_isNull11 = false; // resultCode could change nullability.
/* 149 */           smj_value13 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value8, 0.0D) > 0;
/* 150 */
/* 151 */         }
/* 152 */         if (!smj_isNull11 && smj_value13) {
/* 153 */           boolean smj_isNull14 = false;
/* 154 */           double smj_value16 = -1.0;
/* 155 */           if (smj_isNull6 || smj_value8 == 0) {
/* 156 */             smj_isNull14 = true;
/* 157 */           } else {
/* 158 */             if (smj_isNull8) {
/* 159 */               smj_isNull14 = true;
/* 160 */             } else {
/* 161 */               smj_value16 = (double)(smj_value10 / smj_value8);
/* 162 */             }
/* 163 */           }
/* 164 */           smj_isNull10 = smj_isNull14;
/* 165 */           smj_value12 = smj_value16;
/* 166 */         }
/* 167 */
/* 168 */         else {
/* 169 */           final double smj_value19 = -1.0;
/* 170 */           smj_isNull10 = true;
/* 171 */           smj_value12 = smj_value19;
/* 172 */         }
/* 173 */         if (!smj_isNull10) {
/* 174 */           boolean smj_isNull18 = true;
/* 175 */           double smj_value20 = -1.0;
/* 176 */
/* 177 */           boolean smj_isNull19 = true;
/* 178 */           boolean smj_value21 = false;
/* 179 */
/* 180 */           if (!smj_isNull3) {
/* 181 */             smj_isNull19 = false; // resultCode could change nullability.
/* 182 */             smj_value21 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value5, 0.0D) > 0;
/* 183 */
/* 184 */           }
/* 185 */           if (!smj_isNull19 && smj_value21) {
/* 186 */             boolean smj_isNull22 = false;
/* 187 */             double smj_value24 = -1.0;
/* 188 */             if (smj_isNull3 || smj_value5 == 0) {
/* 189 */               smj_isNull22 = true;
/* 190 */             } else {
/* 191 */               if (smj_isNull5) {
/* 192 */                 smj_isNull22 = true;
/* 193 */               } else {
/* 194 */                 smj_value24 = (double)(smj_value7 / smj_value5);
/* 195 */               }
/* 196 */             }
/* 197 */             smj_isNull18 = smj_isNull22;
/* 198 */             smj_value20 = smj_value24;
/* 199 */           }
/* 200 */
/* 201 */           else {
/* 202 */             final double smj_value27 = -1.0;
/* 203 */             smj_isNull18 = true;
/* 204 */             smj_value20 = smj_value27;
/* 205 */           }
/* 206 */           if (!smj_isNull18) {
/* 207 */             smj_isNull9 = false; // resultCode could change nullability.
/* 208 */             smj_value11 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value12, smj_value20) > 0;
/* 209 */
/* 210 */           }
/* 211 */
/* 212 */         }
/* 213 */         if (smj_isNull9 || !smj_value11) continue;
/* 214 */         if (!smj_loaded) {
/* 215 */           smj_loaded = true;
/* 216 */           smj_isNull2 = smj_leftRow.isNullAt(0);
/* 217 */           smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 218 */           smj_isNull4 = smj_leftRow.isNullAt(2);
/* 219 */           smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 220 */         }
/* 221 */         boolean smj_isNull7 = smj_rightRow1.isNullAt(0);
/* 222 */         UTF8String smj_value9 = smj_isNull7 ? null : (smj_rightRow1.getUTF8String(0));
/* 223 */         smj_numOutputRows.add(1);
/* 224 */
/* 225 */         project_holder.reset();
/* 226 */
/* 227 */         project_rowWriter.zeroOutNullBytes();
/* 228 */
/* 229 */         if (smj_isNull4) {
/* 230 */           project_rowWriter.setNullAt(0);
/* 231 */         } else {
/* 232 */           project_rowWriter.write(0, smj_value6);
/* 233 */         }
/* 234 */         project_result.setTotalSize(project_holder.totalSize());
/* 235 */         append(project_result.copy());
/* 236 */
/* 237 */       }
/* 238 */       if (shouldStop()) return;
/* 239 */     }
/* 240 */   }
/* 241 */ }
