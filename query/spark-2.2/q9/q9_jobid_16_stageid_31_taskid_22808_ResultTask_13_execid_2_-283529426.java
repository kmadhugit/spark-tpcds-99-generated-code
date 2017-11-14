/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private UnsafeRow scan_result;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 019 */   private UnsafeRow filter_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 022 */   private UnsafeRow project_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 025 */
/* 026 */   public GeneratedIterator(Object[] references) {
/* 027 */     this.references = references;
/* 028 */   }
/* 029 */
/* 030 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 031 */     partitionIndex = index;
/* 032 */     this.inputs = inputs;
/* 033 */     scan_input = inputs[0];
/* 034 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 035 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 036 */     scan_scanTime1 = 0;
/* 037 */     scan_batch = null;
/* 038 */     scan_batchIdx = 0;
/* 039 */     scan_colInstance0 = null;
/* 040 */     scan_result = new UnsafeRow(1);
/* 041 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 042 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 1);
/* 043 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 044 */     filter_result = new UnsafeRow(1);
/* 045 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 046 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 1);
/* 047 */     project_result = new UnsafeRow(5);
/* 048 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 049 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   private void scan_nextBatch() throws java.io.IOException {
/* 054 */     long getBatchStart = System.nanoTime();
/* 055 */     if (scan_input.hasNext()) {
/* 056 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 057 */       scan_numOutputRows.add(scan_batch.numRows());
/* 058 */       scan_batchIdx = 0;
/* 059 */       scan_colInstance0 = scan_batch.column(0);
/* 060 */
/* 061 */     }
/* 062 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 063 */   }
/* 064 */
/* 065 */   protected void processNext() throws java.io.IOException {
/* 066 */     if (scan_batch == null) {
/* 067 */       scan_nextBatch();
/* 068 */     }
/* 069 */     while (scan_batch != null) {
/* 070 */       int scan_numRows = scan_batch.numRows();
/* 071 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 072 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 073 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 074 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 075 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 076 */
/* 077 */         if (!(!(scan_isNull))) continue;
/* 078 */
/* 079 */         boolean filter_isNull2 = false;
/* 080 */
/* 081 */         boolean filter_value2 = false;
/* 082 */         filter_value2 = scan_value == 1;
/* 083 */         if (!filter_value2) continue;
/* 084 */
/* 085 */         filter_numOutputRows.add(1);
/* 086 */
/* 087 */         boolean project_isNull = true;
/* 088 */         double project_value = -1.0;
/* 089 */
/* 090 */         boolean project_isNull1 = true;
/* 091 */         boolean project_value1 = false;
/* 092 */
/* 093 */         if (!false) {
/* 094 */           project_isNull1 = false; // resultCode could change nullability.
/* 095 */           project_value1 = 537121672L > 1000000L;
/* 096 */
/* 097 */         }
/* 098 */         if (!project_isNull1 && project_value1) {
/* 099 */           project_isNull = false;
/* 100 */           project_value = 39.755733987833146D;
/* 101 */         }
/* 102 */
/* 103 */         else {
/* 104 */           project_isNull = false;
/* 105 */           project_value = 357.84847600157997D;
/* 106 */         }
/* 107 */         boolean project_isNull6 = true;
/* 108 */         double project_value6 = -1.0;
/* 109 */
/* 110 */         boolean project_isNull7 = true;
/* 111 */         boolean project_value7 = false;
/* 112 */
/* 113 */         if (!false) {
/* 114 */           project_isNull7 = false; // resultCode could change nullability.
/* 115 */           project_value7 = 537116562L > 1000000L;
/* 116 */
/* 117 */         }
/* 118 */         if (!project_isNull7 && project_value7) {
/* 119 */           project_isNull6 = false;
/* 120 */           project_value6 = 115.4589501890093D;
/* 121 */         }
/* 122 */
/* 123 */         else {
/* 124 */           project_isNull6 = false;
/* 125 */           project_value6 = 1039.5177240812948D;
/* 126 */         }
/* 127 */         boolean project_isNull12 = true;
/* 128 */         double project_value12 = -1.0;
/* 129 */
/* 130 */         boolean project_isNull13 = true;
/* 131 */         boolean project_value13 = false;
/* 132 */
/* 133 */         if (!false) {
/* 134 */           project_isNull13 = false; // resultCode could change nullability.
/* 135 */           project_value13 = 537091186L > 1000000L;
/* 136 */
/* 137 */         }
/* 138 */         if (!project_isNull13 && project_value13) {
/* 139 */           project_isNull12 = false;
/* 140 */           project_value12 = 191.24059857045245D;
/* 141 */         }
/* 142 */
/* 143 */         else {
/* 144 */           project_isNull12 = false;
/* 145 */           project_value12 = 1721.0222651030952D;
/* 146 */         }
/* 147 */         boolean project_isNull18 = true;
/* 148 */         double project_value18 = -1.0;
/* 149 */
/* 150 */         boolean project_isNull19 = true;
/* 151 */         boolean project_value19 = false;
/* 152 */
/* 153 */         if (!false) {
/* 154 */           project_isNull19 = false; // resultCode could change nullability.
/* 155 */           project_value19 = 537160165L > 1000000L;
/* 156 */
/* 157 */         }
/* 158 */         if (!project_isNull19 && project_value19) {
/* 159 */           project_isNull18 = false;
/* 160 */           project_value18 = 267.0196781173895D;
/* 161 */         }
/* 162 */
/* 163 */         else {
/* 164 */           project_isNull18 = false;
/* 165 */           project_value18 = 2402.8394383399727D;
/* 166 */         }
/* 167 */         boolean project_isNull24 = true;
/* 168 */         double project_value24 = -1.0;
/* 169 */
/* 170 */         boolean project_isNull25 = true;
/* 171 */         boolean project_value25 = false;
/* 172 */
/* 173 */         if (!false) {
/* 174 */           project_isNull25 = false; // resultCode could change nullability.
/* 175 */           project_value25 = 537098706L > 1000000L;
/* 176 */
/* 177 */         }
/* 178 */         if (!project_isNull25 && project_value25) {
/* 179 */           project_isNull24 = false;
/* 180 */           project_value24 = 342.73583219116983D;
/* 181 */         }
/* 182 */
/* 183 */         else {
/* 184 */           project_isNull24 = false;
/* 185 */           project_value24 = 3084.679095392137D;
/* 186 */         }
/* 187 */         project_rowWriter.zeroOutNullBytes();
/* 188 */
/* 189 */         if (project_isNull) {
/* 190 */           project_rowWriter.setNullAt(0);
/* 191 */         } else {
/* 192 */           project_rowWriter.write(0, project_value);
/* 193 */         }
/* 194 */
/* 195 */         if (project_isNull6) {
/* 196 */           project_rowWriter.setNullAt(1);
/* 197 */         } else {
/* 198 */           project_rowWriter.write(1, project_value6);
/* 199 */         }
/* 200 */
/* 201 */         if (project_isNull12) {
/* 202 */           project_rowWriter.setNullAt(2);
/* 203 */         } else {
/* 204 */           project_rowWriter.write(2, project_value12);
/* 205 */         }
/* 206 */
/* 207 */         if (project_isNull18) {
/* 208 */           project_rowWriter.setNullAt(3);
/* 209 */         } else {
/* 210 */           project_rowWriter.write(3, project_value18);
/* 211 */         }
/* 212 */
/* 213 */         if (project_isNull24) {
/* 214 */           project_rowWriter.setNullAt(4);
/* 215 */         } else {
/* 216 */           project_rowWriter.write(4, project_value24);
/* 217 */         }
/* 218 */         append(project_result);
/* 219 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 220 */       }
/* 221 */       scan_batchIdx = scan_numRows;
/* 222 */       scan_batch = null;
/* 223 */       scan_nextBatch();
/* 224 */     }
/* 225 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 226 */     scan_scanTime1 = 0;
/* 227 */   }
/* 228 */ }
